<?xml version='1.0' encoding='windows-1252'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1"
          xmlns:f="http://java.sun.com/jsf/core"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich"
          xmlns:h="http://java.sun.com/jsf/html">
  <jsp:directive.page contentType="text/html;charset=windows-1252"/>
  <f:view>
    <af:document>
      <af:form>
        <h:dataTable value="#{listaCompraDirecta.comprasDirectas}" var="compraDirecta"
                     id="dt1" binding="#{listaCompraDirecta.dt1}">
          <h:column id="c1">
            <f:facet name="header">
              <h:outputText value="Numero de seguimiento" id="ot2"/>
            </f:facet>
            <h:outputText value="#{compraDirecta.numSeguimiento}" id="ot3"/>
          </h:column>
          <h:column id="c2">
            <f:facet name="header">
              <h:outputText value="Comercio" id="ot4"/>
            </f:facet>
            <h:outputText value="#{compraDirecta.comercio.nombre}" id="ot5"/>
          </h:column>
          <h:column id="c_ac">
            <f:facet name="header">
              <h:outputText value="Acciones"/>
            </f:facet>
            <af:commandButton text="Detalle Compra Directa"
                              action="#{listaCompraDirecta.verInfoCompraDirecta_action}"/>
          </h:column>
        </h:dataTable>
      </af:form>
    </af:document>
  </f:view>
  <!--oracle-jdev-comment:preferred-managed-bean-name:listaSubasta-->
</jsp:root>