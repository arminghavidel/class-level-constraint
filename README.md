## class level constraint
There is some annotations listed below that used to validate post request body.

### NonEmptyList
Checks that all existed lists to be non-empty in the request body.

### NonBlankName
Checks that name properties to not be null or blank.
**@NotNull** annotation could be used to check null strings but **@NonBlankName** also checks empty and blank strings.

### ValidEmail
Checks the email property to be a valid email and matches the pattern provided by <a href=https://www.rfc-editor.org/info/rfc5322>RFC 5322 <a/>.

### PositiveInteger
Checks the integer property to be a non-zero positive integer. **@Min** could be used for the exact same purpose.
**@Min** annotated element must be a number whose value must be higher or equal to the specified minimum.

### ValidSignatureNumbers
Checks the **SigningNodesRequestModel** class to requiredSignatureNumber property be less than or equal to totalSignatureNumber property.

### ValidDecisionWight
Checks the **SigningNodesRequestModel** class to sum of all decisionWeight property of users be equal to totalSignatureNumber property.