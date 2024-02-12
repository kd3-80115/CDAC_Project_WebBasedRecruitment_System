package com.app.utils;

import java.util.Random;
import org.springframework.stereotype.Component;


/**
 * generates OTP with the length
 * of 6 digits
 * */
@Component
public class OtpUtil {

	public String generateOtp() {
	    Random random = new Random();
	    int randomNumber = random.nextInt(999999);
	    String output = Integer.toString(randomNumber);

	    while (output.length() < 6) {
	      output = "0" + output;
	    }
	    return output;
	  }
}
