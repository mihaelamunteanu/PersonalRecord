<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
<style type="text/css" media="print"/>

  
  <table style="border: 1px solid;" width="840">
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr bgcolor="#FFFFEA">
      <td style="text-align:left"><h2>C.M. Dr. RUGINA</h2></td>
      <td style="text-align:right">
          Str. Bd. 9Mai, nr. 1, Bl. A13, Ap.2 <br/>
          Telefon: 0233-237969 <br/>
      </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
      <td style="text-align:left">Pacient: <xsl:value-of select="consultatie/prenume"/>&#160;<xsl:value-of select="consultatie/nume"/>&#160;&#160;</td>
      <td style="text-align:right">CNP: <xsl:value-of select="consultatie/cnp"/>&#160;&#160;&#160;&#160;Telefon: <xsl:value-of select="consultatie/telefon"/></td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
      <td style="text-align:left"> <b>Consultatie din data de <xsl:value-of select="consultatie/DataConsultatie"/> </b> </td>
      <td style="text-align:left"></td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr>
       <td colspan="2">
          <textarea rows="80" cols="111"/>
       </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr>
        <td style="text-align:center">Semnatura: </td>
        <td style="text-align:center">Data: </td>
    </tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
    <tr><td></td><td></td></tr>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>