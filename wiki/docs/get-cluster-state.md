## 获取NameNode信息
### `http://master:50070/jmx?qry=Hadoop:service=NameNode,name=NameNodeInfo`
```json
{
  "beans": [
    {
      "name": "Hadoop:service=NameNode,name=NameNodeInfo",
      "modelerType": "org.apache.hadoop.hdfs.server.namenode.FSNamesystem",
      "Total": 86905466880,
      "ClusterId": "CID-f25514a0-1955-4058-a231-66a08b865ab9",
      "UpgradeFinalized": true,
      "Version": "2.9.2, r826afbeae31ca687bc2f8471dc841b66ed2c6704",
      "Used": 587927552,
      "Free": 76954447872,
      "Safemode": "",
      "NonDfsUsedSpace": 9363091456,
      "PercentUsed": 0.67651385,
      "BlockPoolUsedSpace": 587927552,
      "PercentBlockPoolUsed": 0.67651385,
      "PercentRemaining": 88.54961,
      "CacheCapacity": 0,
      "CacheUsed": 0,
      "TotalBlocks": 6,
      "TotalFiles": 19,
      "NumberOfMissingBlocks": 0,
      "NumberOfMissingBlocksWithReplicationFactorOne": 0,
      "LiveNodes": "{\"slave2:50010\":{\"infoAddr\":\"192.168.17.12:50075\",\"infoSecureAddr\":\"192.168.17.12:0\",\"xferaddr\":\"192.168.17.12:50010\",\"lastContact\":0,\"usedSpace\":195977216,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":3360227328,\"capacity\":28968488960,\"numBlocks\":6,\"version\":\"2.9.2\",\"used\":195977216,\"remaining\":25412284416,\"blockScheduled\":0,\"blockPoolUsed\":195977216,\"blockPoolUsedPercent\":0.6765186,\"volfails\":0,\"lastBlockReport\":23},\"master:50010\":{\"infoAddr\":\"192.168.17.10:50075\",\"infoSecureAddr\":\"192.168.17.10:0\",\"xferaddr\":\"192.168.17.10:50010\",\"lastContact\":0,\"usedSpace\":195973120,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":2642472960,\"capacity\":28968488960,\"numBlocks\":6,\"version\":\"2.9.2\",\"used\":195973120,\"remaining\":26130042880,\"blockScheduled\":0,\"blockPoolUsed\":195973120,\"blockPoolUsedPercent\":0.67650443,\"volfails\":0,\"lastBlockReport\":23},\"slave1:50010\":{\"infoAddr\":\"192.168.17.11:50075\",\"infoSecureAddr\":\"192.168.17.11:0\",\"xferaddr\":\"192.168.17.11:50010\",\"lastContact\":0,\"usedSpace\":195977216,\"adminState\":\"In Service\",\"nonDfsUsedSpace\":3360391168,\"capacity\":28968488960,\"numBlocks\":6,\"version\":\"2.9.2\",\"used\":195977216,\"remaining\":25412120576,\"blockScheduled\":0,\"blockPoolUsed\":195977216,\"blockPoolUsedPercent\":0.6765186,\"volfails\":0,\"lastBlockReport\":23}}",
      "DeadNodes": "{}",
      "DecomNodes": "{}",
      "EnteringMaintenanceNodes": "{}",
      "BlockPoolId": "BP-2106182529-192.168.17.130-1574351591335",
      "NameDirStatuses": "{\"active\":{\"/usr/local/bin/hadoop/hdfs/name\":\"IMAGE_AND_EDITS\"},\"failed\":{}}",
      "NodeUsage": "{\"nodeUsage\":{\"min\":\"0.68%\",\"median\":\"0.68%\",\"max\":\"0.68%\",\"stdDev\":\"0.00%\"}}",
      "NameJournalStatus": "[{\"manager\":\"FileJournalManager(root=/usr/local/bin/hadoop/hdfs/name)\",\"stream\":\"EditLogFileOutputStream(/usr/local/bin/hadoop/hdfs/name/current/edits_inprogress_0000000000000000210)\",\"disabled\":\"false\",\"required\":\"false\"}]",
      "JournalTransactionInfo": "{\"MostRecentCheckpointTxId\":\"209\",\"LastAppliedOrWrittenTxId\":\"210\"}",
      "NNStarted": "Tue Dec 03 01:07:06 EST 2019",
      "NNStartedTimeInMillis": 1575353226534,
      "CompileInfo": "2018-11-13T12:42Z by ajisaka from branch-2.9.2",
      "CorruptFiles": "[]",
      "NumberOfSnapshottableDirs": 0,
      "DistinctVersionCount": 1,
      "DistinctVersions": [
        {
          "key": "2.9.2",
          "value": 3
        }
      ],
      "SoftwareVersion": "2.9.2",
      "NameDirSize": "{\"/usr/local/bin/hadoop/hdfs/name\":4218489}",
      "RollingUpgradeStatus": null,
      "Threads": 44
    }
  ]
}
```

## 获取NameNode状态
### `http://master:50070/jmx?qry=Hadoop:service=NameNode,name=NameNodeStatus`

```json
{
  "beans": [
    {
      "name": "Hadoop:service=NameNode,name=NameNodeStatus",
      "modelerType": "org.apache.hadoop.hdfs.server.namenode.NameNode",
      "NNRole": "NameNode",
      "HostAndPort": "master:9000",
      "SecurityEnabled": false,
      "LastHATransitionTime": 0,
      "BytesWithFutureGenerationStamps": 0,
      "SlowPeersReport": null,
      "SlowDisksReport": null,
      "State": "active"
    }
  ]
}
```

## 获取文件系统信息
### `http://master:50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystem`
```json
{
  "beans": [
    {
      "name": "Hadoop:service=NameNode,name=FSNamesystem",
      "modelerType": "FSNamesystem",
      "tag.Context": "dfs",
      "tag.HAState": "active",
      "tag.TotalSyncTimes": "60 ",
      "tag.Hostname": "master",
      "MissingBlocks": 0,
      "MissingReplOneBlocks": 0,
      "ExpiredHeartbeats": 0,
      "TransactionsSinceLastCheckpoint": 1,
      "TransactionsSinceLastLogRoll": 1,
      "LastWrittenTransactionId": 212,
      "LastCheckpointTime": 1575355768021,
      "CapacityTotal": 86905466880,
      "CapacityTotalGB": 81.0,
      "CapacityUsed": 587927552,
      "CapacityUsedGB": 1.0,
      "CapacityRemaining": 76954423296,
      "CapacityRemainingGB": 72.0,
      "CapacityUsedNonDFS": 9363116032,
      "TotalLoad": 3,
      "SnapshottableDirectories": 0,
      "Snapshots": 0,
      "NumEncryptionZones": 0,
      "LockQueueLength": 0,
      "BlocksTotal": 6,
      "NumFilesUnderConstruction": 0,
      "NumActiveClients": 0,
      "FilesTotal": 19,
      "PendingReplicationBlocks": 0,
      "UnderReplicatedBlocks": 0,
      "CorruptBlocks": 0,
      "ScheduledReplicationBlocks": 0,
      "PendingDeletionBlocks": 0,
      "ExcessBlocks": 0,
      "NumTimedOutPendingReplications": 0,
      "PostponedMisreplicatedBlocks": 0,
      "PendingDataNodeMessageCount": 0,
      "MillisSinceLastLoadedEdits": 0,
      "BlockCapacity": 2097152,
      "NumLiveDataNodes": 3,
      "NumDeadDataNodes": 0,
      "NumDecomLiveDataNodes": 0,
      "NumDecomDeadDataNodes": 0,
      "VolumeFailuresTotal": 0,
      "EstimatedCapacityLostTotal": 0,
      "NumDecommissioningDataNodes": 0,
      "StaleDataNodes": 0,
      "NumStaleStorages": 0,
      "TotalFiles": 19,
      "TotalSyncCount": 2,
      "NumInMaintenanceLiveDataNodes": 0,
      "NumInMaintenanceDeadDataNodes": 0,
      "NumEnteringMaintenanceDataNodes": 0
    }
  ]
}
```

## 获取文件系统状态
### `http://master:50070/jmx?qry=Hadoop:service=NameNode,name=FSNamesystemState`
```json
{
  "beans": [
    {
      "name": "Hadoop:service=NameNode,name=FSNamesystemState",
      "modelerType": "org.apache.hadoop.hdfs.server.namenode.FSNamesystem",
      "CapacityTotal": 86905466880,
      "CapacityUsed": 587927552,
      "CapacityRemaining": 76954423296,
      "TotalLoad": 3,
      "SnapshotStats": "{\"SnapshottableDirectories\":0,\"Snapshots\":0}",
      "NumEncryptionZones": 0,
      "FsLockQueueLength": 0,
      "BlocksTotal": 6,
      "MaxObjects": 0,
      "FilesTotal": 19,
      "PendingReplicationBlocks": 0,
      "UnderReplicatedBlocks": 0,
      "ScheduledReplicationBlocks": 0,
      "PendingDeletionBlocks": 0,
      "BlockDeletionStartTime": 1575353226534,
      "FSState": "Operational",
      "NumLiveDataNodes": 3,
      "NumDeadDataNodes": 0,
      "NumDecomLiveDataNodes": 0,
      "NumDecomDeadDataNodes": 0,
      "VolumeFailuresTotal": 0,
      "EstimatedCapacityLostTotal": 0,
      "NumDecommissioningDataNodes": 0,
      "NumStaleDataNodes": 0,
      "NumStaleStorages": 0,
      "TopUserOpCounts": "{\"timestamp\":\"2019-12-03T02:17:35-0500\",\"windows\":[{\"ops\":[],\"windowLenMs\":60000},{\"ops\":[],\"windowLenMs\":300000},{\"ops\":[],\"windowLenMs\":1500000}]}",
      "TotalSyncCount": 2,
      "TotalSyncTimes": "60 ",
      "NumInMaintenanceLiveDataNodes": 0,
      "NumInMaintenanceDeadDataNodes": 0,
      "NumEnteringMaintenanceDataNodes": 0
    }
  ]
}
```

## 获取块状态
### `http://master:50070/jmx?qry=Hadoop:service=NameNode,name=BlockStats`
```json
{
  "beans": [
    {
      "name": "Hadoop:service=NameNode,name=BlockStats",
      "modelerType": "org.apache.hadoop.hdfs.server.blockmanagement.BlockManager",
      "StorageTypeStats": [
        {
          "key": "DISK",
          "value": {
            "blockPoolUsed": 587927552,
            "capacityNonDfsUsed": 9363116032,
            "capacityRemaining": 76954423296,
            "capacityTotal": 86905466880,
            "capacityUsed": 587927552,
            "nodesInService": 3
          }
        }
      ]
    }
  ]
}
```

## 获取内存状态
### `http://master:50070/jmx?qry=java.lang:type=Memory`
```json
{
  "beans": [
    {
      "name": "java.lang:type=Memory",
      "modelerType": "sun.management.MemoryImpl",
      "ObjectPendingFinalizationCount": 0,
      "HeapMemoryUsage": {
        "committed": 48988160,
        "init": 16777216,
        "max": 1013645312,
        "used": 35534560
      },
      "NonHeapMemoryUsage": {
        "committed": 50659328,
        "init": 2555904,
        "max": -1,
        "used": 49870320
      },
      "Verbose": false,
      "ObjectName": "java.lang:type=Memory"
    }
  ]
}
```