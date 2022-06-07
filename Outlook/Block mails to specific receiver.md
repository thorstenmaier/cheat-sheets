# Block mails to specific receiver

To prevent e-mails from being sent to a specific recipient by mistake, a VB script is used to ask if the recipient in question is in the recipient list.

Here you can see how to activate Visual Basic in Outlook
[https://www.youtube.com/watch?v=2pnHqHhJW9c&ab_channel=Mailhilfe.de]

Put this script to the pre-existing node `ThisOutlookSession`.

```vb
Private Sub Application_ItemSend(ByVal Item As Object, Cancel As Boolean)
    On Error Resume Next ' use lower case for the address  ' LCase converts all addresses in the To field to lower case
    
    BadMailAddress = "bad@address.com"
    If InStr(LCase(Item.To), BadMailAddress) Or InStr(LCase(Item.CC), BadMailAddress) Or InStr(LCase(Item.BCC), BadMailAddress) Then
        Prompt$ = "HALT BIST DU WIRKLICH GANZ SICHER? Diese E-Mail geht an " & BadMailAddress
        If MsgBox(Prompt$, vbYesNo + vbQuestion + vbMsgBoxSetForeground, "Check Address") = vbNo Then
            Cancel = True
        End If
    End If
End Sub
```
