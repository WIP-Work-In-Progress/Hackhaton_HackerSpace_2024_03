"use client";

import React, { useState } from "react";
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
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";
import { SliderTwo } from "@/components/ui/slider-two";

const formSchema = z.object({
  lookingFor: z.string().min(1, {
    message: "Wybierz opcję",
  }),
  minAge: z.number(),
  maxAge: z.number(),
  skills: z.array(
    z.object({
      skill: z.string(),
      yearsRange: z.tuple([z.number(), z.number()]),
    })
  ),
});

export default function PreferencesForm() {
  const form = useForm<z.infer<typeof formSchema>>({
    resolver: zodResolver(formSchema),
    defaultValues: {
      lookingFor: "mentors",
      minAge: 18,
      maxAge: 80,
      skills: [
        {
          skill: "Programming",
          yearsRange: [18, 80],
        },
        {
          skill: "Graphics",
          yearsRange: [18, 80],
        },
        {
          skill: "Project management",
          yearsRange: [18, 80],
        },
      ],
    },
  });

  const [selectedSkills, setSelectedSkills] = useState({}); // State to manage selected skills

  const handleCheckboxChange = (skill) => {
    setSelectedSkills((prev) =>
      prev[skill] ? { ...prev, [skill]: false } : { ...prev, [skill]: true }
    );
  };

  const handleRangeChange = (value, index) => {
    const skills = form.getValues("skills");
    if (skills[index] !== undefined) {
      skills[index].yearsRange = value;
      form.setValue("skills", skills);
    }
  };

  function onSubmit(values: z.infer<typeof formSchema>) {
    console.log(values);
  }

  return (
      <Form {...form}>
        <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-10">
          {/* <FormField
          control={form.control}
          name="lookingFor"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Kogo szukasz?</FormLabel>
              <RadioGroup
                onValueChange={field.onChange}
                defaultValue={field.value}
                className="flex flex-col space-y-1"
              >
                <FormItem className="flex items-center space-x-3 space-y-0">
                  <FormControl>
                    <RadioGroupItem value="mentors" />
                  </FormControl>
                  <FormLabel className="font-normal">Mentorów</FormLabel>
                </FormItem>
                <FormItem className="flex items-center space-x-3 space-y-0">
                  <FormControl>
                    <RadioGroupItem value="mentees" />
                  </FormControl>
                  <FormLabel className="font-normal">Podopiecznych</FormLabel>
                </FormItem>
              </RadioGroup>
              <FormDescription>Z kim chcesz nawiązać kontakt?</FormDescription>
              <FormMessage />
            </FormItem>
          )}
        /> */}
          {form.watch("skills").map((skill, index) => (
            <div key={index}>
              <FormItem>
                <FormLabel>{skill.skill}</FormLabel>
                <SliderTwo
                  defaultValue={skill.yearsRange}
                  max={80}
                  min={18}
                  step={1}
                  index={index}
                  onValueChange={(value) => handleRangeChange(value, index)}
                  formatLabel={(value) => `${value} lat`}
                />
              </FormItem>
            </div>
          ))}
          <div className="flex justify-end py-10">
            <Button type="submit">Submit</Button>
          </div>
        </form>
      </Form>
  );
}
