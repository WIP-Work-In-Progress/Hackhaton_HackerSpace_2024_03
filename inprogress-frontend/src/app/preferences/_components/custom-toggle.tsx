import { Switch } from "@/components/ui/switch";
import React from "react";

interface CustomToggle {
  leftOption: string;
  rightOption: string;
}

export default function CustomToggle({
  leftOption,
  rightOption,
}: CustomToggle) {
  return (
    <div>
      {leftOption}
      <Switch />
      {rightOption}
    </div>
  );
}
