"use client";
import { zodResolver } from "@hookform/resolvers/zod";
import React from "react";
import { useForm } from "react-hook-form";
import { z } from "zod";
import signUpSchema from "../react-hook-form-stuff/signUpFormBackbone";

function SignUpForm() {
  // 1. Define your form.
  const form = useForm<z.infer<typeof signUpSchema>>({
    resolver: zodResolver(signUpSchema),
    defaultValues: {
      username: "",
    },
  });
  function onSubmit(values: z.infer<typeof signUpSchema>) {
    console.log(values);
  }
  return <div>SignUpForm</div>;
}

export default SignUpForm;
