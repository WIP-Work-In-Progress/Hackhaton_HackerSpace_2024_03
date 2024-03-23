"use client";
import { zodResolver } from "@hookform/resolvers/zod";
import React from "react";
import { Form, useForm } from "react-hook-form";
import { z } from "zod";
import signUpSchema from "../react-hook-form-stuff/signUpFormBackbone";
import { Button } from "@/components/ui/button";
import {
  FormControl,
  FormField,
  FormItem,
  FormLabel,
} from "@/components/ui/form";
import { Checkbox } from "@radix-ui/react-checkbox";
import MyInput from "./my-input";
import axios from "axios";
import { useLoginContext } from "@/app/providers/loginContext";

function SignUpFormOld() {
  const message = "Sign Up";
  // const { setIsLoggedIn } = useLoginContext();
  // 1. Define your form.
  const form = useForm<z.infer<typeof signUpSchema>>({
    resolver: zodResolver(signUpSchema),
    defaultValues: {
      gmail: "",
    },
  });
  async function onSubmit(values: z.infer<typeof signUpSchema>) {
    console.log(values);
    try {
      const response = await axios.post(
        "http://localhost:8080/api/v1/auth/register",
        values
      );
      if (response.status === 200) {
        console.log("Registered successfully");
        form.reset(); // Optionally reset the form after successful submission
        // Perform any other actions such as redirecting or updating state
      }
    } catch (e) {
      alert("Failed to register"); // Changed the alert message to indicate registration failure
    }
  }
  return (
    <>
      <div className="message">{message}</div>
      <Form {...form}>
        <FormField
          control={form.control}
          name="username"
          render={({ field }) => (
            <MyInput
              label="Username"
              placeholder="Enter your username"
              field={field}
              type="email"
            />
          )}
        />
        {/* <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <MyInput
              label="Password"
              placeholder="Enter your password"
              field={field}
              type="password"
            />
          )}
        /> */}
        {/* <FormField
          control={form.control}
          name="passwordConfirmation"
          render={({ field }) => (
            <MyInput
              label="Password"
              placeholder="Re-Enter your password"
              field={field}
              type="password"
            />
          )}
        /> */}
        <div className="button-boxes flex flex-col">
          {/* <FormField
            control={form.control}
            name="termsCheck"
            render={({ field }) => (
              <FormItem className="flex justify-between py-2 items-center pr-5">
                <FormControl>
                  <Checkbox
                    checked={field.value}
                    onCheckedChange={field.onChange}
                    name="terms_acceptation"
                    id="terms_acceptation"
                    accessKey="terms_acceptation"
                  />
                </FormControl>
                <FormLabel htmlFor="terms_acceptation">
                  Accept terms and conditions
                </FormLabel>
              </FormItem>
            )}
          /> */}

          <Button type="submit" className="self-end">
            Sign Up
          </Button>
        </div>
      </Form>
    </>
  );
}

export default SignUpForm;
