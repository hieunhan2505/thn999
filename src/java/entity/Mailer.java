
package entity;

import java.io.File;
import java.util.List;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service("mailer")
public class Mailer {

    @Autowired
    JavaMailSender mailer;

    public void send(String from, String to, String subject, String body) {
        try {
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom(from, from);
            helper.setTo(to);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body, true);
            mailer.send(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String from, String to, String subject, String body, String path, String fileName) {
        try {
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom(from, from);
            helper.setTo(to);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.addAttachment(fileName, new File(path));
            mailer.send(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void send(String from, String[] tolist, String[] cclist, String[] bcclist, String subject, String body, List<File> files) {
        try {
            MimeMessage mail = mailer.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
            helper.setFrom(from, from);
            helper.setTo(tolist);
            helper.setCc(cclist);
            helper.setBcc(bcclist);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body, true);
            for (File file : files) {
                FileSystemResource fr = new FileSystemResource(file);
                helper.addAttachment(file.getName(), fr);
            }
            mailer.send(mail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
