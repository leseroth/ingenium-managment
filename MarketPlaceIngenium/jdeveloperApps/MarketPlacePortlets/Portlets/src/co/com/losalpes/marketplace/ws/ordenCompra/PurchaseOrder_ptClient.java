package co.com.losalpes.marketplace.ws.ordenCompra;

import javax.xml.ws.WebServiceRef;
// !THE CHANGES MADE TO THIS FILE WILL BE DESTROYED IF REGENERATED!
// This source file is generated by Oracle tools
// Contents may be subject to change
// For reporting problems, use the following
// Version = Oracle WebServices (11.1.1.0.0, build 110329.0915.20612)

public class PurchaseOrder_ptClient
{
  @WebServiceRef
  private static Purchaseorder_client_ep purchaseorder_client_ep;

  public static PurchaseOrder getOrdenCompra()
  {
    purchaseorder_client_ep = new Purchaseorder_client_ep();
    PurchaseOrder purchaseOrder = purchaseorder_client_ep.getPurchaseOrder_pt();
    return purchaseOrder;
  }
}