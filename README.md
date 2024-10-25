### README.md

---

#### **PL:**

## Opis projektu

Aplikacja na Androida umożliwia użytkownikom wyszukiwanie obrazów za pomocą Pixabay API. Wprowadzenie jednego lub więcej słów kluczowych pozwala na wyświetlenie powiązanych obrazów wraz z ich szczegółami. Aplikacja wspiera Material Design i jest zgodna z wytycznymi Google dotyczącymi najlepszych praktyk projektowania.

## Wymagania techniczne

- **API**: 31+
- **Język**: Kotlin
- **Architektura**: MVVM
- **Biblioteki**:
  - **Jetpack Compose** – interfejs użytkownika
  - **Room** – lokalna baza danych
  - **Retrofit** – obsługa API Pixabay
  - **Coil** – ładowanie obrazów
  - **Hilt** – Dependency Injection
  - **Coroutines** – zarządzanie asynchronicznością

## Funkcjonalności

- **Wyszukiwanie obrazów**: Użytkownik może wprowadzić słowa kluczowe, aby wyszukać obrazy.
- **Wyświetlanie wyników**: Wyniki zawierają miniaturę, nazwę użytkownika Pixabay oraz listę tagów.
- **Przechowywanie offline**: Wyniki są przechowywane lokalnie, aby umożliwić dostęp offline.
- **Szczegóły obrazu**: Po kliknięciu użytkownik może zobaczyć większą wersję obrazu, liczbę polubień, pobrań i komentarzy.

## Dodatkowe informacje

Aplikacja uruchamia wyszukiwanie obrazu z tagiem "fruits" przy starcie. W przypadku konieczności modyfikacji, projekt może być łatwo rozbudowany o dodatkowe funkcjonalności lub poprawki.

---

#### **EN:**

## Project Description

This Android application enables users to search for images using the Pixabay API. Entering one or more keywords allows displaying related images with details. The app supports Material Design and adheres to Google's best design practices.

## Technical Requirements

- **API**: 31+
- **Language**: Kotlin
- **Architecture**: MVVM
- **Libraries**:
  - **Jetpack Compose** – UI framework
  - **Room** – local database
  - **Retrofit** – Pixabay API management
  - **Coil** – image loading
  - **Hilt** – Dependency Injection
  - **Coroutines** – async management

## Features

- **Image Search**: Users can input keywords to search for images.
- **Results Display**: Each result includes a thumbnail, Pixabay username, and list of tags.
- **Offline Storage**: Results are cached locally for offline access.
- **Image Details**: Upon click, users can view a larger image version, likes, downloads, and comments.

## Additional Information

On startup, the app initiates an image search with the "fruits" tag. If modifications are needed, the project is structured to be easily extendable for additional features or fixes.
