import { z } from "zod";
import { passwordSchemaField, emailSchemaField } from "./schemaFormFields";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

const signInSchema = z.object({
  email: emailSchemaField,
  password: passwordSchemaField,
});

export default signInSchema;
