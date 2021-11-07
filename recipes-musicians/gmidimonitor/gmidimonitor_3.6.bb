SUMMARY = "GTK+ application that shows MIDI events"
LICENSE = "LGPLv2 & PD"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=f1e8b3e96c0abf4e3abb3b0f8e8eaf7f \
    file://COPYING.icon;md5=1d49e879912b1ea962200c42d117ca6c \
"

inherit meson pkgconfig gtk-icon-cache

DEPENDS += " \
    gtk+3 \
    jack \
"

SRC_URI = "git://github.com/schnitzeltony/gmidimonitor.git;branch=master;protocol=https"
SRCREV = "af366f49970ed91a414e5b832a13436417be4bdb"
S = "${WORKDIR}/git"
