import { z } from "zod";
import { passwordSchemaField, usernameSchemaField } from "./schemaFormFields";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";

const signInSchema = z.object({
  username: usernameSchemaField,
  password: passwordSchemaField,
});

export default signInSchema;
