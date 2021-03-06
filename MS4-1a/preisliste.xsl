<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">

<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">		
	<fo:layout-master-set>	
	  <fo:simple-page-master master-name="Preisliste"		
	  						 page-height="297mm"
	  						 page-width="21cm"
	  						 margin-left="25mm"
	  						 margin-right="28mm"
	  						 margin-top="28mm"
	  						 margin-bottom="28mm">
	    <fo:region-body 										
	    		   margin-top="2cm"
	    		   margin-bottom="2cm"/>
	    <fo:region-before extent="2cm"/>					
	    <fo:region-after extent="2cm"/>																	
	  </fo:simple-page-master>
	</fo:layout-master-set>

	<fo:page-sequence master-reference="Preisliste">		
	  <fo:flow flow-name="xsl-region-body">
	    <fo:block font-size="18px" text-align="center" color="#1abc9c" space-before="0.5cm" space-after="0.5cm">
	    	Allgold Produktpreise
	    </fo:block>
	  
	    <fo:block>
	      <fo:table background-color="#1abc9c" border-style="solid" border-width="1px" border-color="black">
	        <fo:table-header color="white" border-style="dotted" border-width="1px" border-color="black">
	          <fo:table-row>
	            <fo:table-cell>
	              <fo:block>Produkt ID</fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block>Bezeichnung</fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block>Preis</fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block>Haltbarkeit</fo:block>
	            </fo:table-cell>
	          </fo:table-row>
	      	</fo:table-header>
	    

	      	<fo:table-footer font-size="8px" color="white" border-style="dotted" border-width="1px" border-color="black">
	          <fo:table-row>
	            <fo:table-cell number-columns-spanned="4">
	              <fo:block text-align="center">© 2018 Allgold GmbH</fo:block>
	            </fo:table-cell>
	          </fo:table-row>
	      	</fo:table-footer>

			<xsl:for-each select="/pma_xml_export/database/table">

	      	<fo:table-body>
	      		<fo:table-row>
	            <fo:table-cell>
	              <fo:block><xsl:value-of select="column[@name='productID']"/></fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block><xsl:value-of select="column[@name='name']"/></fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block><xsl:value-of select="column[@name='price']"/></fo:block>
	            </fo:table-cell>

	            <fo:table-cell>
	              <fo:block><xsl:value-of select="column[@name='durability']"/></fo:block>
	            </fo:table-cell>
	          </fo:table-row>

	        </fo:table-body>
	        </xsl:for-each>

	    </fo:table>
	  </fo:block>	




	  </fo:flow>
	</fo:page-sequence>

</fo:root>

</xsl:template>
</xsl:stylesheet>