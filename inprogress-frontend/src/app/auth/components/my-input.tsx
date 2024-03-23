import IInputProps from "@/app/models/IInputProps";
import {
  FormControl,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import React from "react";

function MyInput(props: IInputProps) {
  return (
    <FormItem>
      <FormLabel>{props.label}</FormLabel>
      <FormControl>
        <Input
          type={props.type ? props.type : "text"}
          placeholder={props.placeholder}
          {...props.field}
        />
      </FormControl>
      <FormMessage />
    </FormItem>
  );
}

export default MyInput;
