"use client";

import React from "react";
import { Form, FormControl, FormField, FormItem } from "@/components/ui/form";
import { Button } from "@/components/ui/button";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import MyInput from "./my-input";
import axios from "axios";

const formSchema = z.object({
  firstName: z.string().min(1, {
    message: "Proszę wprowadzić swoje imię",
  }),
  lastName: z.string().min(1, {
    message: "Proszę wprowadzić swoje nazwisko",
  }),
  email: z.string().email({
    message: "Proszę wprowadzić poprawny adres email",
  }),
  password: z.string().min(8, {
    message: "Hasło musi mieć co najmniej 8 znaków",
  }),
});

export default function SignUpForm() {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
    },
  });

  function onSubmit(values: z.infer<typeof formSchema>) {
    console.log(values);
    axios.post("http://localhost:8080/api/v1/auth/register", values);
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <FormField
          control={form.control}
          name="firstName"
          render={({ field }) => (
            <FormItem>
              <FormControl>
                <MyInput
                  label="Imię"
                  placeholder="imię"
                  field={field}
                  type="text"
                />
              </FormControl>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="lastName"
          render={({ field }) => (
            <FormItem>
              <FormControl>
                <MyInput
                  label="Nazwisko"
                  placeholder="nazwisko"
                  field={field}
                  type="text"
                />
              </FormControl>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="email"
          render={({ field }) => (
            <FormItem>
              <FormControl>
                <MyInput
                  label="Email"
                  placeholder="example@test.com"
                  field={field}
                  type="email"
                />
              </FormControl>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <FormItem>
              <FormControl>
                <MyInput
                  label="Hasło"
                  placeholder="hasło"
                  field={field}
                  type="password"
                />
              </FormControl>
            </FormItem>
          )}
        />
        <div className="flex justify-end mr-2">
          <Button type="submit">Zarejestruj się</Button>
        </div>
      </form>
    </Form>
  );
}
