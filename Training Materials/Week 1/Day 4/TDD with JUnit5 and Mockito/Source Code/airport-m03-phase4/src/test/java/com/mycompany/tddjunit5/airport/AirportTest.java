package com.mycompany.tddjunit5.airport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

class AirportTest {

	@DisplayName("Given there is an economy flight")
	@Nested
	class EconomyFlightTest {

		private Flight economyFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			economyFlight = new EconomyFlight("1");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("when we have a usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Then you can add and remove him from an economy flight")
			public void testEconomyFlightUsualPassenger() {

				assertAll("Verify all conditions for a usual passenger on an economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(mike)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size()),
						() -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
						() -> assertEquals(true, economyFlight.removePassenger(mike)),
						() -> assertEquals(0, economyFlight.getPassengersSet().size())

				);

			}

			@DisplayName("Then you cannot add him to an economy flight more than once")
			@RepeatedTest(5)
//			@Disabled
			public void testEconomyFlightUsualPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
				for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					economyFlight.addPassenger(mike);
				}

				assertAll("Verify a usual passenger can be added to an economy flight only once",

						() -> assertEquals(1, economyFlight.getPassengersSet().size()),
						() -> assertTrue(economyFlight.getPassengersSet().contains(mike)),
						() -> assertTrue(economyFlight.getPassengersSet().contains(mike))

				);
			}
		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {
			@Test
			@DisplayName("Then you can add him and cannot remove him from an economy flight")
			public void testEconomyFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger on an economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size()),
						() -> assertTrue(economyFlight.getPassengersSet().contains(john)),
						() -> assertEquals(false, economyFlight.removePassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengersSet().size())

				);
			}
		}

	}

	@DisplayName("Given there is an business flight")
	@Nested
	class BusinessFlightTest {

		private Flight businessFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("When we have a usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Then you cannot add or remove him from an business flight")
			public void testBusinessFlightUsualPassenger() {
				assertAll("Verify all conditions for a usual passenger on a business flight",
						() -> assertEquals(false, businessFlight.addPassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengersSet().size()),
						() -> assertEquals(false, businessFlight.removePassenger(mike)),
						() -> assertEquals(0, businessFlight.getPassengersSet().size())

				);
			}

		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {

			@Test
			@DisplayName("Then you can add him but not remove him from an business flight")
			public void testBusinessFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger on a business flight",
						() -> assertEquals(true, businessFlight.addPassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengersSet().size()),
						() -> assertEquals(false, businessFlight.removePassenger(john)),
						() -> assertEquals(1, businessFlight.getPassengersSet().size())

				);
			}

			@DisplayName("Then you cannot add him to an business flight more than once")
			@RepeatedTest(5)
			public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
				for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					businessFlight.addPassenger(john);
				}

				assertAll("Verify a usual passenger can be added to an economy flight only once",

						() -> assertEquals(1, businessFlight.getPassengersSet().size()),
						() -> assertTrue(businessFlight.getPassengersSet().contains(john)), () -> assertTrue(
								new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("John"))

				);
			}

		}

	}

	@DisplayName("Given there is an premium flight")
	@Nested
	class PremiumFlightTest {

		private Flight premiumFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			premiumFlight = new PremiumFlight("3");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("when we have a usual passenger")
		class UsualPassenger {
			@Test
			@DisplayName("Then you cannot add or remove him from a premium flight")
			public void testPremiumFlightUsualPassenger() {

				assertAll("Verify all conditions for a usual passenger on a premium flight",

						() -> assertEquals(false, premiumFlight.addPassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size()),
						() -> assertEquals(false, premiumFlight.removePassenger(mike)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size())

				);

			}
		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {
			@Test
//			@Disabled
			@DisplayName("Then you can add him and remove him from an premium flight")
			public void testEconomyFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger on a premium flight",

						() -> assertEquals(true, premiumFlight.addPassenger(john)),
						() -> assertEquals(1, premiumFlight.getPassengersSet().size()),
						() -> assertEquals(true, premiumFlight.removePassenger(john)),
						() -> assertEquals(0, premiumFlight.getPassengersSet().size())

				);
			}

			@DisplayName("Then you cannot add him to an premium flight more than once")
			@RepeatedTest(5)
			public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
				for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
					premiumFlight.addPassenger(john);
				}

				assertAll("Verify a VIP passenger can be added to an premium flight only once",

						() -> assertEquals(1, premiumFlight.getPassengersSet().size()),
						() -> assertTrue(premiumFlight.getPassengersSet().contains(john)), () -> assertTrue(
								new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("John"))

				);
			}

		}
	}
}