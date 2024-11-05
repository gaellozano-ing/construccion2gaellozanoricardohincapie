/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AppGR.controller.request;

import appgr.model.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateInvoiceRequest {
    private long PersonId;
    private long partnerId;
    private double amount;
    private String status;
    private Invoice invoiceid;
    private int item;
    private String description;
    private double amountt;
}
