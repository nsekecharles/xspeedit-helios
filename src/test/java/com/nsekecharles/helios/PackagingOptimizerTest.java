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
}