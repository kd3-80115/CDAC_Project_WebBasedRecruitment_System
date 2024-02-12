package com.app.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendOtpEmail(String email, String otp) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		// Create a MimeMessageHelper instance to assist with handling MimeMessage
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		// Set the recipient email address
		mimeMessageHelper.setTo(email);

		// Set the subject of the email
		mimeMessageHelper.setSubject("Verify otp from Get Hired");

		// HTML content with inline CSS for styling
		String htmlContent = "<div style='border: 2px solid #007BFF; padding: 20px;'>"
				+ "<h2 style='color: #007BFF;'>Get Hired - OTP Verification</h2>"
				+ "<p>Your One Time Password (OTP): <strong style='color: #28a745; font-size: 18px;'>" + otp
				+ "</strong></p>"
				+ "<p style='color: #6c757d; font-size: 14px;'>This OTP is valid for a limited time. Please use it to verify your account.</p>"
				+ "</div>";

		// Set the HTML content of the email with content type "text/html"
		mimeMessageHelper.setText(htmlContent, true);
		javaMailSender.send(mimeMessage);
	}

	public void sendPasswordEmail(String email) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		// Create a MimeMessageHelper instance to assist with handling MimeMessage
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		// Set the recipient email address
		mimeMessageHelper.setTo(email);

		// Set the subject of the email
		mimeMessageHelper.setSubject("Set Password");

		// Set the HTML content of the email, including a verification link with email
		// and OTP parameters
		mimeMessageHelper.setText("<div><a href=\"http://localhost:7878/set-password?email=" + email
				+ "\" target=\"_blank\">click link to set password</a></div>", true);

		javaMailSender.send(mimeMessage);
	}
}
