import { z } from "zod";
import {
  firstNameSchemaField,
  lastNameSchemaField,
  passwordSchemaField,
  emailSchemaField,
} from "./schemaFormFields";

const signUpSchema = z.object({
  firstName: firstNameSchemaField,
  lastName: lastNameSchemaField,
  password: passwordSchemaField,
  email: emailSchemaField,
});
export default signUpSchema;
