package incovid.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Controller
@RequestMapping("image")
public class ImageController {

    @GetMapping(value = "/logo", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage() throws IOException {
        URL url = getClass().getResource("/image/logo_nav.png");
        InputStream in = url.openStream();
        return IOUtils.toByteArray(in);
    }
}
