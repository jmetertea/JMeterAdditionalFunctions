# ChangeCase function 

Change Case function update string according to given case, support the following cases:
<ul>
  <li>
Lower camel case, as: lowerCamelCase - name: "LOWER_CAMEL_CASE"
</li>
  <li>
Upper camel case, as: UpperCamelCase - name: "UPPER_CAMEL_CASE"
</li>
  <li>
Snake or lower underscore case, as: snake_lower_underscore_case - name: "SNAKE_CASE"/"LOWER_UNDERSCORE"
</li>
  <li>
Lisp or kebab or spinal or lower hyphen case, as: lis-keba-spinal-lower-case - name: "KEBAB_CASE"/"LISP_CASE"/"SPINAL_CASE"/"LOWER_HYPHEN"
</li>
  
  <li>
Train case, as: TRAIN-CASE - name: "TRAIN_CASE"
</li>
  <li>
Upper underscore case, as: UPPER_UNDERSCORE_CASE - name: "UPPER_UNDERSCORE"
</li>

# Usage

Parameter 1 - String to change case. Mandatory

Parameter 2 - Case Mode (case insenstive). Optional (Default "LOWER_CAMEL_CASE") 

- if not valid mode will return string as is.

Parameter 3 - Name of variable. Optional reference name for reusing the value computed by this function.

For example: ${__caseFormat("MyString", "LOWER_CAMEL_CASE", outputVariable);

Will save in outputVariable value "myString"
