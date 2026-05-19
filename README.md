# 📱 App Structure Navigation Template

A simple **Android Jetpack Compose App Structure Template** built using **Material 3**.

This project is **not a real app**, but a **sample reference template** created to understand and experiment with common Android app architecture and UI patterns such as:

- Navigation Drawer
- Bottom Navigation Bar
- Top App Bar
- Modal Bottom Sheet
- Navigation Component
- Floating Action Button (FAB)
- Alert Dialog
- Dynamic App Bar Title & Icon Updates

The goal of this project is to serve as a **starter template/reference architecture** for future Android applications.

---

## ✨ Features

### 🧭 Navigation Drawer
- Material 3 `ModalNavigationDrawer`
- Rounded drawer UI
- Selectable drawer items
- Dynamic selected state

### 📌 Bottom Navigation Bar
- Material 3 `NavigationBar`
- Dynamic selected item
- Navigation between screens
- Custom icons

### 🔝 Top App Bar
- Dynamic title updates based on current route
- Dynamic screen icon updates
- More menu button
- Drawer opening support

### 📄 Modal Bottom Sheet
- Material 3 `ModalBottomSheet`
- Custom drag handle
- Rounded corners
- Selectable items
- Highlighted selected state

### ➕ Floating Action Button
- Custom FAB styling
- Opens dialog interaction

### ⚠️ Alert Dialog
- Material 3 `AlertDialog`
- Icon
- Title
- Confirm & dismiss buttons
- Custom colors and rounded shape

### 🛣️ Navigation System
- Jetpack Compose Navigation
- Route-based screen navigation
- Dynamic UI updates using `NavController`
- Single source of truth for screen state

---

## 🧱 Project Structure

```txt
app/
│
├── components/
│   ├── TopBar.kt
│   ├── BottomBar.kt
│   ├── AppDrawer.kt
│   └── BottomSheet.kt
│
├── navigation/
│   ├── Screens.kt
│   └── AppNavigation.kt
│
├── bottombar_screens/
│
├── drawer_screens/
│
├── bottomsheet_screens/
│
├── MainActivity.kt
└── MainView.kt
```

---

## 🏗️ Architecture Used

This template follows a **Navigation-driven UI architecture**.

Instead of manually managing selected screens using a `ViewModel`, the project uses:

```kotlin
currentBackStackEntryAsState()
```

to determine:

- Current screen
- Current route
- Top bar title
- Selected bottom bar item
- Selected drawer item
- Selected bottom sheet item
- Dynamic app bar icon

### Why?

`NavController` already knows the active destination, making it the **single source of truth**.

This avoids duplicated UI state.

---

## 🧩 Components Used

### Material 3 Components

- `Scaffold`
- `TopAppBar`
- `NavigationBar`
- `NavigationBarItem`
- `ModalNavigationDrawer`
- `ModalDrawerSheet`
- `ModalBottomSheet`
- `FloatingActionButton`
- `AlertDialog`
- `ListItem`
- `HorizontalDivider`

### Navigation

- `NavController`
- `NavHost`
- `composable()`
- `currentBackStackEntryAsState()`

---

## 🎨 UI Features

### Dynamic Top Bar

The top app bar updates automatically based on the selected screen:

```txt
Drawer Item 1 → Item 1 icon + title
BB Item 2 → Bottom Bar icon + title
BS Item 3 → Bottom Sheet icon + title
```

---

## 🛠️ Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material 3**
- **Compose Navigation**
- **Android Studio**

---

## 🚀 Purpose of this Project

This template was created for:

- Learning Jetpack Compose architecture
- Understanding navigation patterns
- Building reusable UI components
- Experimenting with Material 3
- Creating a reusable starter structure for future apps

---

## 🔮 Future Improvements

Possible additions:

- Theme switcher
- Dark/Light mode toggle
- Snackbar support with sample content
- Adaptive layouts for tablets
- Bottom sheet scaffold
- Nested navigation graphs
- Shared ViewModels
- Animations & transitions
- Authentication flow

---

## 👨‍💻 Author

Built for learning, experimentation, and reusable Android app architecture reference.
