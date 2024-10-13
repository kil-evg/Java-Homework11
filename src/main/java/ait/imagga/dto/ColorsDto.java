package ait.imagga.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ColorsDto {
    private List<ColorInfoDto> background_colors;
    private List<ColorInfoDto> foreground_colors;
    private List<ColorInfoDto> image_colors;
}
