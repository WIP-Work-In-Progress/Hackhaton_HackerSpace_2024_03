import { z } from "zod";
import EMessages from "../enum/Messages";
import { passwordRegex } from "../data/regex";

export const passwordSchemaField = z.string();
// .min(8, EMessages.PASSWORD_TOO_SHORT)
// .max(50, EMessages.PASSWORD_TOO_LONG)
// .regex(passwordRegex, EMessages.PASSWORD_INVALID);
export const emailSchemaField = z
  .string()
  .min(2, EMessages.EMAIL_TOO_SHORT)
  .max(50, EMessages.EMAIL_TOO_LONG)
  .email(EMessages.EMAIL_INVALID);

export const firstNameSchemaField = z
  .string()
  .min(2, EMessages.FIRST_NAME_TOO_SHORT)
  .max(50, EMessages.FIRST_NAME_TOO_LONG);
export const lastNameSchemaField = z
  .string()
  .min(2, EMessages.LAST_NAME_TOO_SHORT)
  .max(50, EMessages.LAST_NAME_TOO_LONG);
