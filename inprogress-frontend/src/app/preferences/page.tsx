import { Separator } from "@/components/ui/separator";
import React from "react";
import PreferencesForm from "../whoami/_components/preferences-form";

function page() {
  return (
    <div className="px-10">
      <h2>Preferencje</h2>
      <Separator />
      <PreferencesForm />
    </div>
  );
}

export default page;
