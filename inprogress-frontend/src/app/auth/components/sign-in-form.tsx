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
import { setCookie } from "cookies-next";
import { Checkbox } from "@/components/ui/checkbox";
function SignInForm() {
  const { isLoggedIn, setIsLoggedIn } = useLoginContext();
  const form = useForm<z.infer<typeof signInSchema>>({
    resolver: zodResolver(signInSchema),
    defaultValues: {
      email: "",
      password: "",
    },
  });
  async function onSubmit(values: z.infer<typeof signInSchema>) {
    console.log(values);
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/auth/login",
        {
          username: values.email,
          password: values.password,
        },
      );
      console.log(response);
      if (response.status === 200) {
        console.log("Logged in");
        setIsLoggedIn(true);
        setCookie("token", response.data);
      }
    } catch (e) {
      alert("Failed to login");
    }
  }
  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <FormField
          control={form.control}
          name="email"
          render={({ field }) => (
            <MyInput
              label="Adres email"
              placeholder="example@test.com"
              field={field}
              type="email"
            />
          )}
        />
        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <MyInput
              label="Hasło"
              placeholder="Hasło"
              type="password"
              field={field}
            />
          )}
        />
        <div className="flex justify-end mr-2">
          <Button type="submit" className="self-end">
            Zaloguj
          </Button>
        </div>
      </form>
    </Form>
  );
}

export default SignInForm;
