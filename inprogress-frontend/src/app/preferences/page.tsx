import { Separator } from "@/components/ui/separator";
import React from "react";
import CustomToggle from "./_components/custom-toggle";
import PreferencesForm from "./_components/preferences-form";

export default function page() {
  return (
    <div>
      <h2>Preferencje</h2>
      <Separator />
      <PreferencesForm />


    </div>
  );
}
