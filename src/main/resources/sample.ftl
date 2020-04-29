<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>
    Welcome ${user.name}
  </h1>
  <p>Our latest product:
  ${user.name} is ${user.age} years old
  </p>
  
  <#list user.animals as i>
    <tr>-${i.shipmentName}</tr>
</#list>
  
  enddd
${invoice.name}
</body>
</html>