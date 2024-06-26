"use client";
import { createRef, useEffect, useMemo, useRef, useState } from "react";
import TinderCard from "react-tinder-card";
import PersonDetailsComponent from "./person-details-component";
import PersonInfoComponent from "./person-info-component";
import { Button } from "@/components/ui/button";
import {
  MoveDiagonal,
  MoveDown,
  MoveLeft,
  MoveRight,
  MoveUp,
} from "lucide-react";
import { db } from "@/lib/mock_db";

// TODO - fetch data from db

export default function SwiperComponent() {
  const [currentIndex, setCurrentIndex] = useState(db.length - 1);
  const [characters, setCharacters] = useState(db);
  const [personDetailsId, setPersonDetailsId] = useState<null | string>(null);
  const [currentPerson, setCurrentPerson] = useState();
  useEffect(() => {}, []);
  const currentIndexRef = useRef(currentIndex);
  const childRefs = useMemo(
    () =>
      Array(db.length)
        .fill(0)
        .map((i) => createRef()),
    [],
  );

  const swipe = async (dir) => {
    if (currentIndex < db.length) {
      await childRefs[currentIndex].current.swipe(dir); // Swipe the card!
    }
  };
  const updateCurrentIndex = (val) => {
    setCurrentIndex(val);
    currentIndexRef.current = val;
  };

  const goBack = async () => {
    setPersonDetailsId(null);
    console.log("test", currentIndex);
    await childRefs[currentIndex].current.restoreCard();
  };

  const swiped = (direction, person) => {
    // const personCard = document.getElementById(`person-card-${personCardId}`)

    switch (direction) {
      case "left": {
        updateCurrentIndex(currentIndex - 1);
        const filteredCharacters = characters.filter(
          (character) => character.id !== person.id,
        );
        setCharacters(filteredCharacters);
        break;
      }

      case "right": {
        console.log(personDetailsId);
        updateCurrentIndex(currentIndex - 1);
        const filteredCharacters = characters.filter(
          (character) => character.id !== person.id,
        );
        const curr = JSON.parse(sessionStorage.getItem("liked") || "[]");
        sessionStorage.setItem("liked", JSON.stringify([...curr, person.id]));
        setCharacters(filteredCharacters);
        console.log(personDetailsId);
        break;
      }

      case "top": {
        updateCurrentIndex(currentIndex - 1);
        const filteredCharacters = characters.filter(
          (character) => character.id !== person.id,
        );
        setCharacters(filteredCharacters);
      }

      case "down": {
        setCurrentPerson(person);
        setPersonDetailsId(person.id);
        break;
      }
    }
    console.log(direction);
  };

  return (
    <div className="flex  justify-center items-center mt-4 overflow-hidden">
      <ul className="w-80 h-[30rem]">
        {characters.map((person, index) => (
          <li key={index}>
            <TinderCard
              ref={childRefs[index]}
              onSwipe={(dir) => swiped(dir, person)}
            >
              <div className="swiper-person-card w-80 h-[30rem] bg-white absolute items-end flex rounded-[1rem] overflow-hidden">
                <img
                  src={`${person.url}`}
                  alt="profile-image"
                  className="h-[30rem] absolute"
                />
                <PersonInfoComponent
                  person={person}
                  fullInfo={false}
                  fontColor="text-white"
                ></PersonInfoComponent>
                <div
                  aria-label="hidden"
                  className="swiper-person-card-overlay"
                ></div>
              </div>
            </TinderCard>
          </li>
        ))}
      </ul>
      <div className="flex buttons absolute bottom-0 w-full justify-center gap-4 pb-8">
        <div>
          <Button
            onClick={() => {
              swipe("left");
            }}
            className="p-6"
          >
            <MoveLeft />
          </Button>
        </div>
        <div>
          <Button
            onClick={() => {
              swipe("down");
            }}
            className="p-6"
          >
            <MoveDown />
          </Button>
        </div>
        <div>
          <Button
            onClick={() => {
              swipe("right");
            }}
            className="p-6"
          >
            <MoveRight />
          </Button>
        </div>
      </div>
      {personDetailsId && (
        <PersonDetailsComponent
          person={currentPerson}
          goBack={goBack}
        ></PersonDetailsComponent>
      )}
    </div>
  );
}
