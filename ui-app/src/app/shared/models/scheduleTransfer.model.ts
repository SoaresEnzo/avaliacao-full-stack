export interface IScheduleTransferRequest {
    originAccount: string| null,
    destinationAccount: string| null,
    value: number| null,
    requestedDate: string| null,
    scheduledDate: string| null,
}