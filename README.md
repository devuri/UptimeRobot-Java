# UptimeRobot-Java


Work in progress.

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
| deleteAlertContact | No |

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

# Credits/Mentions

Inspiration from [JavaTelegramBot-API](https://github.com/zackpollard/JavaTelegramBot-API)'s builders