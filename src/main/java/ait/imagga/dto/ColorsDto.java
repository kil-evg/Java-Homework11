package ait.imagga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ColorsDto {
//    private String closest_palette_color;
//    private String closest_palette_color_parent;
//    private double percent;
    private List<ColorInfoDto> background_colors;
    private List<ColorInfoDto> foreground_colors;
    private List<ColorInfoDto> image_colors;
}
