package info.amytan.tacocloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placedAt;

    @NotBlank(message="Delivery name required.")
    private String deliveryName;

    @NotBlank(message="Street name required.")
    private String deliveryStreet;

    @NotBlank(message="City name required.")
    private String deliveryCity;

    @NotBlank(message="State name required.")
    private String deliveryState;

    @NotBlank(message="Zip code required.")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number.")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
    message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
