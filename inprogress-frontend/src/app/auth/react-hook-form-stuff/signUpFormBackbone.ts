import { z } from "zod";
import EMessages from "../enum/Messages";
import {
  firstNameSchemaField,
  lastNameSchemaField,
  passwordSchemaField,
  usernameSchemaField,
} from "./schemaFormFields";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

const signUpSchema = z
  .object({
    firstName: firstNameSchemaField,
    lastName: lastNameSchemaField,
    password: passwordSchemaField,
    passwordConfirmation: passwordSchemaField,
    username: usernameSchemaField,
    termsCheck: z
      .boolean()
      .default(false)
      .refine((value) => value === true, {
        message: EMessages.TERMS_NOT_CHECKED,
        path: ["termsCheck"],
      }),
  })
  .refine((data) => data.password === data.passwordConfirmation, {
    message: EMessages.PASSWORDS_NOT_MATCH,
    path: ["passwordConfirmation"],
  });

export default signUpSchema;
