# JMeterAdditionalFunctions

Add ChangeCase function to JMeter

Support the following case:
<ul>
  <li>
Lower camel case as: lowerCamelCase - name: "LOWER_CAMEL_CASE"
</li>
  <li>
Upper camel case as: UpperCamelCase - name: "UPPER_CAMEL_CASE"
</li>
  <li>
Snake or lower underscore case as: snake_lower_underscore_case - name: "SNAKE_CASE"/"LOWER_UNDERSCORE"
</li>
  <li>
Lisp or kebab or spinal or lower hyphen case as: lis-keba-spinal-lower-case - name: "KEBAB_CASE"/"LISP_CASE"/"SPINAL_CASE"/"LOWER_HYPHEN"
</li>
  
  <li>
Train/upper underscore case as: TRAIN-CASE - name: "TRAIN_CASE"
</li>
  <li>
Train/upper underscore case as: TRAIN_UPPER_UNDERSCORE_CASE - name: "UPPER_UNDERSCORE"
</li>

# Usage

${__caseFormat("MyString", "LOWER_CAMEL_CASE", outputVariable);

Will save in outputVariable value "myString"
