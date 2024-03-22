"use client";

import React from "react";
import CustomToggle from "./custom-toggle";
import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Button } from "@/components/ui/button";
import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

const formSchema = z.object({
  lookingFor: z.string().min(2, {
    message: "Username must be at least 2 characters.",
  }),
});

export default function PreferencesForm() {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      lookingFor: "",
    },
  });

  function onSubmit(values: z.infer<typeof formSchema>) {
    console.log(values);
  }

  return (
    <Form {...form}>
      <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-8">
        <FormField
          control={form.control}
          name="lookingFor"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Kogo szukasz?</FormLabel>
              <FormControl>
                <CustomToggle
                  leftOption="Mentorów"
                  rightOption="Podopiecznych"
                />
              </FormControl>
              <FormDescription>Z kim chcesz nawiązać kontakt?</FormDescription>
              <FormMessage />
            </FormItem>
          )}
        />
        <Button type="submit">Submit</Button>
      </form>
    </Form>
  );
}
