import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs";
import React from "react";
import SignInForm from "./sign-in-form";
import SignUpForm from "./sign-up-form";

function FormLayout({ children }: { children: React.ReactNode }) {
  return (
    <>
      <Tabs defaultValue="signIn" className="flex flex-col w-full">
        <TabsList>
          <TabsTrigger value="signIn">Sign In</TabsTrigger>
          <TabsTrigger value="signUp">Sign Up</TabsTrigger>
        </TabsList>
        <TabsContent value="signIn">
          <SignInForm />
        </TabsContent>
        <TabsContent value="signUp">
          <SignUpForm />
        </TabsContent>
      </Tabs>
    </>
  );
}

export default FormLayout;
