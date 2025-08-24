# EliteMart - Android E-Commerce App

<div align="center">
  <img src="presentation/src/main/res/mipmap-xxxhdpi/ic_launcher.webp" alt="EliteMart Logo" width="120" height="120"/>
  <h3>Your Premium Shopping Destination</h3>
</div>

## 📱 Overview

EliteMart is a modern, feature-rich Android e-commerce application built with cutting-edge Android development technologies. The app provides users with a seamless shopping experience, featuring product browsing, cart management, user authentication, order tracking, and more.

## ✨ Features

### 🛍️ **Shopping Experience**
- **Product Catalog**: Browse through extensive product listings with categories
- **Product Details**: Comprehensive product information with images and descriptions
- **Search & Filter**: Find products quickly with advanced search capabilities
- **Featured Products**: Curated selection of popular and trending items

### 🛒 **Cart & Checkout**
- **Shopping Cart**: Add/remove products with quantity management
- **Cart Summary**: Detailed breakdown of costs including tax and shipping
- **Checkout Process**: Streamlined ordering with address management
- **Order Confirmation**: Real-time order status updates

### 👤 **User Management**
- **User Registration**: Secure account creation with email verification
- **User Login**: Secure authentication system
- **Profile Management**: Personal information and preferences
- **Address Management**: Multiple shipping addresses support

### 📋 **Order Management**
- **Order History**: Complete order tracking and history
- **Order Status**: Real-time updates (Pending, Delivered, Cancelled)
- **Order Details**: Comprehensive order information and tracking

### 🎨 **User Interface**
- **Modern Material Design 3**: Latest Material Design principles
- **Dark/Light Theme**: Customizable app appearance
- **Responsive Design**: Optimized for various screen sizes
- **Smooth Animations**: Enhanced user experience with animations

## 🏗️ Architecture

EliteMart follows **Clean Architecture** principles with a modular structure:

```
EliteMart/
├── 📱 presentation/          # UI Layer (Jetpack Compose)
├── 🧠 domain/               # Business Logic Layer
├── 💾 data/                 # Data Layer (Repository & Network)
└── 🔧 gradle/               # Build Configuration
```

### **Architecture Components**

- **Presentation Layer**: Jetpack Compose UI with MVVM pattern
- **Domain Layer**: Use cases, repositories interfaces, and business models
- **Data Layer**: Repository implementations, network services, and data models
- **Dependency Injection**: Koin for dependency management

## 🛠️ Technology Stack

### **Core Technologies**
- **Language**: Kotlin 2.0.0
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM + Clean Architecture
- **Dependency Injection**: Koin 4.0.0
- **Navigation**: Navigation Compose 2.9.0

### **Networking & Data**
- **HTTP Client**: Ktor 3.1.0
- **Serialization**: Kotlinx Serialization
- **Image Loading**: Coil Compose 2.7.0

### **Testing**
- **Unit Testing**: JUnit 4, Mockito, Coroutines Test
- **UI Testing**: Espresso, Compose Testing
- **Dependency Injection Testing**: Koin Test

### **Build Tools**
- **Build System**: Gradle with Kotlin DSL
- **Android Gradle Plugin**: 8.8.2
- **Minimum SDK**: API 21 (Android 5.0)
- **Target SDK**: API 34 (Android 14)

## 🚀 Getting Started

### **Prerequisites**
- Android Studio Hedgehog (2023.1.1) or later
- Android SDK API 34
- Kotlin 2.0.0 or later
- JDK 17 or later

### **Installation**

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/EliteMart.git
   cd EliteMart
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Open the project from the cloned directory
   - Wait for Gradle sync to complete

3. **Configure API Endpoints**
   - Update network configuration in `data/src/main/java/com/cscorner/data/di/NetworkModule.kt`
   - Set your backend API base URL

4. **Build and Run**
   - Connect an Android device or start an emulator
   - Click "Run" button or press `Shift + F10`
   - Select your target device and wait for installation

### **Build Variants**
- **Debug**: Development version with debugging enabled
- **Release**: Production version with optimizations

## 📱 Screenshots

*[Screenshots will be added here]*

## 🔧 Configuration

### **Environment Variables**
The app can be configured for different environments by modifying the build configuration files.

### **API Configuration**
Update the network configuration in the data module to point to your backend services.

## 🧪 Testing

### **Running Tests**

```bash
# Unit Tests
./gradlew test

# Instrumented Tests
./gradlew connectedAndroidTest

# All Tests
./gradlew check
```

### **Test Coverage**
- Unit tests for business logic
- UI tests for critical user flows
- Integration tests for data layer

## 📦 Dependencies

### **Core Dependencies**
- **AndroidX Core**: 1.16.0
- **Lifecycle Runtime**: 2.9.0
- **Activity Compose**: 1.10.1
- **Compose BOM**: 2024.04.01

### **UI Dependencies**
- **Material Design 3**: Latest Material components
- **Navigation Compose**: 2.9.0
- **Coil**: Image loading and caching

### **Networking**
- **Ktor Client**: HTTP networking
- **Kotlinx Serialization**: JSON serialization

## 🚀 Deployment

### **Release Build**
1. Update version in `build.gradle.kts`
2. Run `./gradlew assembleRelease`
3. Sign the APK with your release keystore
4. Test the release build thoroughly

### **Play Store Deployment**
1. Generate signed APK/AAB
2. Create Play Store listing
3. Upload and publish

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### **Code Style**
- Follow Kotlin coding conventions
- Use meaningful variable and function names
- Add comments for complex logic
- Maintain consistent formatting

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Team

- **Developer**: [Your Name]
- **Design**: [Designer Name]
- **Backend**: [Backend Developer Name]

## 📞 Support

For support and questions:
- 📧 Email: [your.email@example.com]
- 🐛 Issues: [GitHub Issues](https://github.com/yourusername/EliteMart/issues)
- 📱 App Store: [Play Store Link]

## 🔄 Changelog

### **Version 1.0.0** *(Current)*
- Initial release
- Core e-commerce functionality
- User authentication
- Product catalog
- Shopping cart
- Order management

---

<div align="center">
  <p>Made with ❤️ for Android developers</p>
  <p>Built with modern Android development best practices</p>
</div>
