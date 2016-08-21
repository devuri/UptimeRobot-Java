### *Notice: This library uses the [v2 version](https://uptimerobot.com/apiv2) of the UptimeRobot API which isn't fully released yet and may contain bugs! *

# UptimeRobot-Java


Work in progress.

# Maven  

UptimeRobot-Java is available on maven central:  

```
<dependency>
  <groupId>com.madyoda</groupId>
  <artifactId>uptimerobot</artifactId>
  <version>0.1</version>
</dependency>
```

# Implementation

| Method | Implemented |
|--------|-------------|
| getAccountDetails | Yes |
| getMonitors | Yes |
| newMonitor | No |
| editMonitor | No |
| deleteMonitor | No |
| resetMonitor | No |
| getAlertContacts | No |
| newAlertContact | No |
| editAlertContact | No |
| deleteAlertContact | No |
| getMWindows | No |
| newMWindow | No |
| editMWindow | No |
| deleteMWindow | No |


# Usage

All methods are based on a builder system and the UptimeRobot object

### Obtaining UptimeRobot object

```java
UptimeRobot uptimeRobot = new UptimeRobot("your_api_key_here");
```

### getAccountDetails

```java
GetAccountDetailsRequest.builder().setUptimeRobot(uptimeRobot).get();
```
returns the AccountDetails object

## getMonitors

```java
GetMonitorsRequest.builder().setUptimeRobot(uptimeRobot).get();
```
returns a Monitors object, in which you can then do something like this:  
```java
Monitors monitors = GetMonitorsRequest.builder().setUptimeRobot(uptimeRobot).get();
            for(Monitors.Monitor monitor : monitors.getMonitors()){
                System.out.println(monitor.getFriendlyName());
            }
```

Possible optionals:



# Credits/Mentions

Inspiration from [JavaTelegramBot-API](https://github.com/zackpollard/JavaTelegramBot-API)'s builders