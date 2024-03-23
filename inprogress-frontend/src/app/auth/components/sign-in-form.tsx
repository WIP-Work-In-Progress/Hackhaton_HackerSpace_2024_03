"use client";
import React from "react";
import signInSchema from "../react-hook-form-stuff/signInFormBackbone";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { z } from "zod";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import MyInput from "./my-input";
import { Button } from "@/components/ui/button";
import axios from "axios";
import { useLoginContext } from "@/app/providers/loginContext";

function SignInForm() {
  const { isLoggedIn, setIsLoggedIn } = useLoginContext();
  const form = useForm<z.infer<typeof signInSchema>>({
    resolver: zodResolver(signInSchema),
    defaultValues: {
      username: "",
      password: "",
    },
  });
  async function onSubmit(values: z.infer<typeof signInSchema>) {
    console.log(values);
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/auth/login",
        values
      );
      if (response.status === 200) {
        console.log("Logged in");
        setIsLoggedIn(true);
      }
    } catch (e) {
      alert("Failed to login");
    }
  }
  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)}>
        <FormField
          control={form.control}
          name="username"
          render={({ field }) => (
            <MyInput
              label="Username"
              placeholder="Enter your username"
              field={field}
            />
          )}
        />
        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <MyInput
              label="Password"
              placeholder="Enter your password"
              field={field}
            />
          )}
        />
        // TODO: ADD CHECKBOX
        <Button type="submit" className="self-end">
          Sign In
        </Button>
      </form>
    </Form>
  );
}

export default SignInForm;
