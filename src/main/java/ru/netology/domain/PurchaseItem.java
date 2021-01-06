package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseItem {

    private int id;
    private int productId;
    private String productName;
    private int productPrise;
    private int count;
}
