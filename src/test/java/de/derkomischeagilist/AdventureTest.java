package de.derkomischeagilist;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdventureTest {

    private Adventure adventure;

    @BeforeEach
    void setUp() {
        adventure = new Adventure();
    }


    @Test
    void currentTimeLooksGood() {
        assertThat("timestamp", TimeService.currentTime("Europe/Berlin"), greaterThan(-1L));
    }

    @Test
    void AdventureStartsOnTheLoo() {
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void AdventureProvidesHelpTextAtStartup() {
        String beginText = adventure.Begin();
        assertThat(beginText, containsStringIgnoringCase("enter command"));
        assertThat(beginText, containsStringIgnoringCase("help"));
    }


    @Test
    void LookingAroundInTheLooThenICanSeeMagazines() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("magazines"));
    }

    @Test
    void LookingAroundInTheLooThenICantSeeACoin() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can't see the coin
        assertThat(actual, not(containsStringIgnoringCase("coin")));
    }

    @Test
    void LookingAroundInTheLooThenIWillFindScrumDeveloperCard() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look around");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("pathetic scrum developer"));
        assertThat(actual, containsStringIgnoringCase("card"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAScrumGuide() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("scrum guide"));
    }

    @Test
    void LookingAtMagazinesInTheLooThenICanSeeAUsedMickyMouseMagazine() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("look at magazines");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("used micky mouse magazine"));
    }

    @Test
    void EnteringAnInvalidCommandResultsInHelpfulResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, not(containsStringIgnoringCase("invalid command")));
        assertThat(actual, containsStringIgnoringCase("Try to 'look around', 'look at magazines' (better get your gloves), 'look at toilet paper', 'flush toilet' or just 'use door to washroom' to escape the smell."));
    }

    @Test
    void enteringAnInvalidCommandResultsInFunnyResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String command = "Do something stupid";
        String actual = adventure.tell(command);
        //Then i can see funny response
        assertThat(actual, containsStringIgnoringCase(String.format("Sorry, I don't understand '%s'", command)));
        assertThat(actual, containsStringIgnoringCase("Try to 'look around', 'look at magazines' (better get your gloves), 'look at toilet paper', 'flush toilet' or just 'use door to washroom' to escape the smell."));
    }
    @Test
    void PuttingPaperTowelsInTheBinInTheWashRoom() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I put paper towels in the bin
        String actual = adventure.tell("put paper towels in the bin");
        //Then the bin gets filled with used paper towels
        assertThat(actual, containsStringIgnoringCase("Bin has been filled with used paper towels. Now the bin is overflowing with even more dirty paper towels."));
    }

    @Test
    void EnteringHelpInWashroomGivesHintForDod() {
        //given i am in the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;

        //When i ask for help
        String actual = adventure.tell("help");

        //Then i see dod response
        assertThat(actual, containsStringIgnoringCase("read DoD"));
    }

    @Test
    void enteringHelpInLooGivesHintForDod() {
        //given i am in the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));

        //When i ask for help
        String actual = adventure.tell("help");

        //Then i see flush toilet response
        assertThat(actual, containsStringIgnoringCase("flush toilet"));
    }

    @Test
    void EnteringAnInvalidCommandStillIncludesPreviousResponse() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When i look around
        String actual = adventure.tell("Do something stupid");
        //Then i can see magazines
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void GoingThroughDoorInTheLooThenICanSeeTheWashRoom() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        String actual = adventure.tell("use door to washroom");
        //Then i can see the wash room
        assertThat(actual, containsStringIgnoringCase("wash room"));
    }

    @Test
    void LookingAroundInTheWashRoomThenIWillFindDoorAndSink() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the wash room
        adventure.tell("use door to washroom");
        //When I look around
        String actual = adventure.tell("look around");
        //Then i can see a sink and a door
        assertThat(actual, containsStringIgnoringCase("nasty sink"));
    }
    
    @Test
    void LookingAroundInTheTeamOfficeThenIWillFindCubiclesAndWorkers() {
    	//given i am on the loo
    	assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
    	//When I go into the team office
        adventure.tell("use door to team office");
        //When I look around
        String actual = adventure.tell("look around");
        //Then i can see cubicles and workers
        assertThat(actual, containsStringIgnoringCase("You see many flip charts, sticky notes and other things on the walls. In the middle of the room there are several dirty old cubicles. Nearly each one of the cubicles has a worker in front of it staring directly at the computer screen."));
        //Then i can see a burndown chart
        assertThat(actual, containsStringIgnoringCase("One wall holds a burndown chart. Its line is horizontal! Seems that the team does not finish anything ;) -> Close your PBI´s"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenIAmGreetedByMyTeammates() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("use door to team office");
        //Then i am greeted by my teammates
        assertThat(actual, containsStringIgnoringCase("Hey, you moron! ;)"));
    }

    @Test
    void GoingThroughDoorInTheTeamRoomThenMyTeammatesAreSmartAndSmelly() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("use door to team office");
        //Then my teammates are smart
        assertThat(actual, containsStringIgnoringCase("smart"));
        //Then my teammates are smelly
        assertThat(actual, containsStringIgnoringCase("smelly"));
    }

    @Test
    void commandsAreCaseInsensitive() {
        //given i am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I go into the Team Office
        String actual = adventure.tell("uSe DoOr tO tEaM oFfIcE");
        //Then the command leads me to the team room
        assertThat(actual, not(containsStringIgnoringCase("invalid command")));
    }

    @Test
    void lookAroundShowsDodOnTheDoor() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I look around
        String actual = adventure.tell("look around");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("you notice a dod on the door"));
    }

    @Test
    void readDodShowsDodDetails() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I read the DoD
        String actual = adventure.tell("read DoD");
        //Then I find the DoD
        assertThat(actual, containsStringIgnoringCase("hands washed"));
        assertThat(actual, containsStringIgnoringCase("paper towels in bin"));
        assertThat(actual, containsStringIgnoringCase("toilet flushed"));
    }

    @Test
    void executeCommandWashHandsInWashRoom() {
        //given I am on the washroom
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        //When I wash my hands
        String actual = adventure.tell("wash hands");
        //Then I am washing my hands
        assertThat(actual, containsStringIgnoringCase("Unfortunately the soap dispenser is empty :( So you wash your hands only with hot water."));
    }

    @Test
    void examineToiletPaperShowsToiletPaperDetails() {
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        //When I examine the toilet paper for the first time
        String actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the first piece is written: \"Scrum Master:"));
        assertThat(actual, containsStringIgnoringCase("There are more pieces on the ground"));
        //When I examine the toilet paper for the second time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("Another one states:"));
        //When I examine the toilet paper for the third time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("Next piece says: \"Product Owner:"));
        //When I examine the toilet paper for the third time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the last piece is written: \"Developers:"));
        assertThat(actual, containsStringIgnoringCase("I remember. I need to find my Scrum team"));
        //When I examine the toilet paper for the fourth time
        actual = adventure.tell("look at toilet paper");
        //Then I see the toilet paper details
        assertThat(actual, containsStringIgnoringCase("On the first piece is written: \"Scrum Master:"));
    }

    @Test
    void readAJokeOnLooSuccessful(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Why do we tell actors to 'break a leg?' - Because every play has a cast ;)"));
    }

    @Test
    void readAJokeInWashroomUnsuccesfull(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.currentRoom = adventure.washroom;
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("There is no joke in this room."));
    }

    @Test
    void commitSuicideInLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void readAJokeOnLooAndCommitSuicide(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("read a joke");
        assertThat(actual, containsStringIgnoringCase("Why do we tell actors to 'break a leg?' - Because every play has a cast ;)"));
        actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void moveToHallwayAndCommitSuicide(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("use door to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a wash room."));
        actual = adventure.tell("commit suicide");
        assertThat(actual, containsStringIgnoringCase("you wake up on the Loo"));
    }

    @Test
    void moveFromLooToWashroomAndBackToLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("use door to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a wash room."));
        actual = adventure.tell("use door to loo");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void moveFromLooToWashroomAndTooHallwayAndBackToLoo(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("use door to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a wash room."));
        actual = adventure.tell("use door to hallway");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("use door to loo");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void commandsInCaps(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        // Commands shall work, regardless if written in lower or uppercase
        String actual = adventure.tell("USe dooR to washrOOm");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a wash room."));
        actual = adventure.tell("USE DOOR TO HALLWAY");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("USE DOOR TO LOO");
        assertThat(actual, containsStringIgnoringCase("You are on the loo again. Still smelly."));
    }

    @Test
    void moveToHallwayAndOpenSpookyDoor(){
        //given I am on the loo
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        String actual = adventure.tell("use door to washroom");
        assertThat(actual, containsStringIgnoringCase("You enter a room that looks like a wash room."));
        actual = adventure.tell("use door to hallway");
        assertThat(actual, containsStringIgnoringCase("Welcome to the hallway to hell."));
        actual = adventure.tell("inspect the spooky door");
        assertThat(actual, containsStringIgnoringCase("and next to it is a rusty keypad"));
        actual = adventure.tell("use keypad");
        assertThat(actual, containsStringIgnoringCase("number of the scrum values"));
        actual = adventure.tell("5");
        assertThat(actual, containsStringIgnoringCase("You made it"));
    }

    @Test
    void useKeypadInHallwayWithInvalidKey(){
        //given I enter the hallway
        assertThat(adventure.Begin(), containsStringIgnoringCase("you wake up on the Loo"));
        adventure.tell("use door to hallway");
        // when I use the keypad
        String actual = adventure.tell("use keypad");
        // i see the description of the keypad
        assertThat(actual, containsStringIgnoringCase("number of the scrum values"));
        actual = adventure.tell("10");
        assertThat(actual, containsStringIgnoringCase("but nothing happens"));
    }

    @Test
    void checkStartingRoom() {
        // when
        adventure.Begin();

        // then
        assertThat(adventure.whereAreWe(), equalTo(Location.LOO));
    }

    @Test
    void afterUsingDoorToWashroomWeAreInTheWashroom() {
        // when
        adventure.Begin();
        adventure.tell("use door to washroom");

        // then
        assertThat(adventure.whereAreWe(), equalTo(Location.WASHROOM));
    }
}
