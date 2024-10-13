package ait.imagga;
import ait.imagga.dto.ColorsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class ImaggaColoursAppl {
    public static void main(String[] args) {
        String imgUrl = "https://www.deutschland.de/sites/default/files/styles/image_container/public/media/image/tdt_04072023_tourismus_frankfurt_skyline.jpg?h=8d1da3c3";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjX2IzZDgwOWQ3YTEzZjE2ZTphYTIxNDA0ZTY4YzVjYTE3YmZkYjRkYzEzNmMzMWE5Ng==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);

        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        ResponseEntity<ColorsResponseDto> response = restTemplate.exchange(request, ColorsResponseDto.class);

        System.out.printf("%-30s %-30s %-20s%n", "color name", "parent color name", "coverage percent");

        response.getBody().getResult().getColors().getBackground_colors().forEach(color ->
                System.out.printf("%-30s %-30s %-30.2f%n",
                        color.getClosest_palette_color(),
                        color.getClosest_palette_color_parent(),
                        color.getPercent())
        );
        response.getBody().getResult().getColors().getForeground_colors().forEach(color ->
                System.out.printf("%-30s %-30s %-30.2f%n",
                        color.getClosest_palette_color(),
                        color.getClosest_palette_color_parent(),
                        color.getPercent())
        );
        response.getBody().getResult().getColors().getImage_colors().forEach(color ->
                System.out.printf("%-30s %-30s %-30.2f%n",
                        color.getClosest_palette_color(),
                        color.getClosest_palette_color_parent(),
                        color.getPercent())
        );
    }
}
