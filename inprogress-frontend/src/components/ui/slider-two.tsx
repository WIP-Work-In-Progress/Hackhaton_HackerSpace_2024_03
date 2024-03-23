import * as React from "react";
import * as SliderPrimitive from "@radix-ui/react-slider";

import { cn } from "@/lib/utils";

interface SliderProps {
  className?: string;
  min: number;
  max: number;
  step: number;
  defaultValue: [number, number];
  formatLabel?: (value: number) => string;
  onValueChange?: (newValues: number[], index: number) => void; // Add index to the function signature
  index: number; // Add index prop
}

const SliderTwo = React.forwardRef<HTMLDivElement, SliderProps>(
  (
    {
      className,
      min,
      max,
      step,
      defaultValue,
      formatLabel,
      onValueChange,
      index, // Destructure index from props
      ...props
    },
    ref
  ) => {
    const [localValues, setLocalValues] =
      React.useState<number[]>(defaultValue);

    const handleValueChange = (newValues: number[]) => {
      setLocalValues(newValues);
      if (onValueChange) {
        onValueChange(newValues, index); // Pass index to onValueChange
      }
    };

    return (
      <SliderPrimitive.Root
        ref={ref}
        min={min}
        max={max}
        step={step}
        value={localValues}
        onValueChange={handleValueChange}
        className={cn(
          "relative flex w-full touch-none select-none items-center",
          className
        )}
        {...props}
      >
        <SliderPrimitive.Track className="relative h-1.5 w-full grow overflow-hidden rounded-full bg-neutral-700">
          <SliderPrimitive.Range className="absolute  h-full bg-primary" />
        </SliderPrimitive.Track>
        {localValues.map((value, index) => (
          <React.Fragment key={index}>
            <div
              className="absolute text-center"
              style={{
                left: `calc(${((value - min) / (max - min)) * 100}% + 0px)`,
                top: `10px`,
              }}
            >
              {formatLabel ? formatLabel(value) : value}
            </div>
            <SliderPrimitive.Thumb className="block h-4 w-4 rounded-full border border-primary/50 bg-background shadow transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring disabled:pointer-events-none disabled:opacity-50" />
          </React.Fragment>
        ))}
      </SliderPrimitive.Root>
    );
  }
);

SliderTwo.displayName = SliderPrimitive.Root.displayName;

export { SliderTwo };
