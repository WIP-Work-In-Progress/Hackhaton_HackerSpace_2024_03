import { Separator } from "@/components/ui/separator";
import React from "react";
import PreferencesForm from "../whoami/_components/preferences-form";

function page() {
  return (
    <div className="bg-secondary py-6 space-y-4">
      <h2 className="text-xl px-10">Preferencje</h2>
      <Separator className="bg-black w-full" />
      <div className="px-10">
        <PreferencesForm />
      </div>
    </div>
  );
}

export default page;
