package com.nsekecharles.helios;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PackagingOptimizerTest {

    @Test
    void should_return_empty_string_given_empty_articles_list() {
        // Given
        var input = "";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("");
    }

    @Test
    void should_return_a_single_box_given_a_single_number_of_items() {
        // Given
        var input = "3";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("3");
    }

    @Test
    void should_return_a_single_box_given_multiple_items_fitting_in_one_box() {
        // Given
        var input = "324";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("324");
    }

    @Test
    void should_return_a_two_boxes_given_multiple_items_fitting_in_two_boxes() {
        // Given
        var input = "3246";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("324/6");
    }

    @Test
    void should_return_a_two_boxes_given_multiple_items_fitting_in_two_boxes_2() {
        // Given
        var input = "3836";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("3/8/36");
    }

    @Test
    void should_return_expected_exemple() {
        // Given
        var input = "163841689525773";

        // When
        String actual = PackagingOptimizer.optimize(input);

        // Assert
        assertThat(actual).isEqualTo("163/8/41/6/8/9/52/5/7/73");
    }
}