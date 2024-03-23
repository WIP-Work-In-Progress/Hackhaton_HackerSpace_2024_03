import { Separator } from "@/components/ui/separator";
import React from "react";
import PreferencesForm from "../whoami/_components/preferences-form";

function page() {
  return (
    <div className="px-10">
      <h2>Preferencje</h2>
      <Separator />
      <div className="py-5 bg-secondary">
        <PreferencesForm />
      </div>
    </div>
  );
}

export default page;
