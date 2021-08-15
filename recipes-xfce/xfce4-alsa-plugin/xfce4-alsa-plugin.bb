SUMMARY = "Simple ALSA volume control for xfce4-panel"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7702f203b58979ebbc31bfaeb44f219c"

inherit vala gettext meson

DEPENDS += "xfce4-panel alsa-lib"

SRC_URI = "git://github.com/equeim/xfce4-alsa-plugin.git"
SRCREV = "7192d344631fc20f9c64b45cd8af7485cd5048c4"
PV = "0.3.0"
S = "${WORKDIR}/git"

FILES:${PN} += " \
    ${datadir}/xfce4 \
    ${libdir}/xfce4/panel \
"
