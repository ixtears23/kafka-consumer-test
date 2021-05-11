package junseok.rest.demoinflearnrestapi.events;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    void javaBean() {
        // Given
        String name = "Event";
        String description = "Spring";

        // When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        // then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    void testFree() {
        // given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        // when
        event.update();

        // then
        assertThat(event.isFree()).isTrue();

        // given
        event = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();

        // when
        event.update();

        // then
        assertThat(event.isFree()).isFalse();

        // given
        event = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();

        // when
        event.update();

        // then
        assertThat(event.isFree()).isFalse();
    }

    @Test
    void testOffline() {

        // given
       Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();

        // when
        event.update();

        // then
        assertThat(event.isOffline()).isTrue();

        // given
       event = Event.builder()
                .build();

        // when
        event.update();

        // then
        assertThat(event.isOffline()).isFalse();
    }


}
